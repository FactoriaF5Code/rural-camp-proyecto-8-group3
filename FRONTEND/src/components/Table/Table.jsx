/* eslint-disable react/prop-types */
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

function FixedHeaderTable({ activeButton, searchResults }) {
  // const [data, setData] = useState([]);
  const [tableHeaders, setTableHeaders] = useState([]);

  useEffect(() => {
    const fetchDataFromDatabase = async () => {
      try {
        let response;
        if (activeButton === "books") {
          response = await axios.get("http://localhost:9000/books");
          setTableHeaders([
            "ID",
            "Título",
            "Autor",
            "ISBN",
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
              {Array.isArray(searchResults) && searchResults.length > 0 && searchResults.map((row, index) => (

              <TableRow key={index}>
                {activeButton === "books" ? (
                  <React.Fragment>
                    <TableCell className="table-cell">{row.item.idBooks}</TableCell> {/* Accede a item.idBooks ya que searchResults contiene objetos con una estructura específica */}
                    <TableCell className="table-cell">{row.item.title}</TableCell>
                    <TableCell className="table-cell">{row.item.author}</TableCell>
                    <TableCell className="table-cell">{row.item.isbn}</TableCell>
                    <TableCell className="table-cell">{row.item.status}</TableCell>
                  </React.Fragment>
                ) : (
                  <React.Fragment>
                    <TableCell className="table-cell">{row.item.idMembers}</TableCell>
                    <TableCell className="table-cell">{row.item.name}</TableCell>
                    <TableCell className="table-cell">{row.item.lastName}</TableCell>
                    <TableCell className="table-cell">{row.item.email}</TableCell>
                    <TableCell className="table-cell">{row.item.phone}</TableCell>
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
