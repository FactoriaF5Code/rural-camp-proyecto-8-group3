import "./Table.css";
import { useState, useEffect } from "react";
import {
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableCell,
  TableContainer,
  Paper,
} from "@mui/material";

function FixedHeaderTable() {
  const [data, setData] = useState([]);

  const fetchDataFromDatabase = async () => {
    try {
      const response = await fetch("http://localhost:9000/api/books");
      const books = await response.json();
      setData(books);
    } catch (error) {
      console.error("Error fetching books:", error);
    }
  };

  useEffect(() => {
    fetchDataFromDatabase();
  }, []);

  return (
    <TableContainer component={Paper} className="table-container">
      <Table aria-label="fixed header table">
        <TableHead>
          <TableRow className="table-header">
          <TableCell className="table-cell-header">ID</TableCell>
            <TableCell className="table-cell-header">ISBN</TableCell>
            <TableCell className="table-cell-header">Título</TableCell>
            <TableCell className="table-cell-header">Autor</TableCell>
            <TableCell className="table-cell-header">Estado</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row) => (
            <TableRow key={row.id}>
              <TableCell className="table-cell">{row.id}</TableCell>
              <TableCell className="table-cell">{row.isbn}</TableCell>
              <TableCell className="table-cell">{row.title}</TableCell>
              <TableCell className="table-cell">{row.author}</TableCell>
              <TableCell className="table-cell">{row.status}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default FixedHeaderTable;
