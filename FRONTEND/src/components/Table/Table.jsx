/* eslint-disable react/prop-types */
import React, { useState, useEffect } from "react";
import axios from "axios";
import {
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableCell,
  TableContainer,
  Paper,
} from "@mui/material";
import "./Table.css";


function FixedHeaderTable({
  activeButton,
  firstResult,
}) {
  const [data, setData] = useState([]);
  const [tableHeaders, setTableHeaders] = useState([]);

  useEffect(() => {
    const fetchDataFromDatabase = async () => {
      try {
        let response;
        if (activeButton === "books") {
          response = await axios.get("http://localhost:9000/books");
          setTableHeaders(["ID", "ISBN", "Título", "Autor", "Estado"]);
        } else if (activeButton === "members") {
          response = await axios.get("http://localhost:9000/members");
          setTableHeaders(["ID", "Nombre", "Apellidos", "Email", "Teléfono"]);
        }

        if (response && response.data) {
          setData(response.data);
        }
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchDataFromDatabase();
  }, [activeButton]);

  // Filtrar los datos basados en el primer resultado de la búsqueda
  const filteredData = firstResult ? data.filter(item => item.title === firstResult.title && item.author === firstResult.author) : [];

  return (
    <div>
      <TableContainer component={Paper} className="table-container">
        <Table aria-label="fixed header table">
          <TableHead>
            <TableRow>
              {tableHeaders.map((header) => (
                <TableCell key={header} className="table-cell-header">
                  {header}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {filteredData.map((row, index) => (
              <TableRow key={index}>
                {activeButton === "books" ? (
                  <React.Fragment>
                    <TableCell className="table-cell">{row.idBooks}</TableCell>
                    <TableCell className="table-cell">{row.isbn}</TableCell>
                    <TableCell className="table-cell">{row.title}</TableCell>
                    <TableCell className="table-cell">{row.author}</TableCell>
                    <TableCell className={`table-cell ${row.status === "Disponible" ? "available" : "not-available"}`}>
                      <div className="status-container">
                        <div className={`status-circle ${row.status === "Disponible" ? "available" : "not-available"}`}></div>
                        {row.status === "Disponible" || row.status === "Devolución" ? (
                          <button onClick={() => window.location.href = row.status === "Disponible" ? `http://localhost:5173/prestamo/${row.idBooks}` : `http://localhost:5173/devolucion-ok/${row.idBooks}`}>
                            {row.status}
                          </button>
                        ) : (
                          <span>{row.status}</span>
                        )}
                      </div>
                    </TableCell>
                  </React.Fragment>
                ) : (
                  <React.Fragment>
                    <TableCell className="table-cell">{row.idMember}</TableCell>
                    <TableCell className="table-cell">{row.name}</TableCell>
                    <TableCell className="table-cell">{row.lastName}</TableCell>
                    <TableCell className="table-cell">{row.email}</TableCell>
                    <TableCell className="table-cell">{row.phone}</TableCell>
                  </React.Fragment>
                )}
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
}

export default FixedHeaderTable;
