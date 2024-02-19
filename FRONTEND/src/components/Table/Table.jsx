import "./Table.css";
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

function FixedHeaderTable({ activeButton }) {
  const [data, setData] = useState([]);
  const [tableHeaders, setTableHeaders] = useState([]);

  useEffect(() => {
    const fetchDataFromDatabase = async () => {
      try {
        let response;
        if (activeButton === "books") {
          response = await axios.get("http://localhost:9000/books");
          setTableHeaders([
            "ID",
            "ISBN",
            "Título",
            "Autor",
            "Estado"
          ]);
        } else if (activeButton === "members") {
          response = await axios.get("http://localhost:9000/members");
          setTableHeaders([
            "ID",
            "Nombre",
            "Apellidos",
            "Email",
            "Teléfono"
          ]);
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

  return (
    <div>
      <TableContainer component={Paper} className="table-container">
        <Table aria-label="fixed header table">
          <TableHead>
            <TableRow>
              {tableHeaders.map(header => (
                <TableCell key={header} className="table-cell-header">{header}</TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {data.map((row, index) => (
              <TableRow key={index}>
                {activeButton === "books" ? (
                  <React.Fragment>
                    <TableCell className="table-cell">{row.idBooks}</TableCell>
                    <TableCell className="table-cell">{row.isbn}</TableCell>
                    <TableCell className="table-cell">{row.title}</TableCell>
                    <TableCell className="table-cell">{row.author}</TableCell>
                    <TableCell className="table-cell">{row.status}</TableCell>
                  </React.Fragment>
                ) : (
                  <React.Fragment>
                    <TableCell className="table-cell">{row.idMembers}</TableCell>
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
