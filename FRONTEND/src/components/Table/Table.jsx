import './Table.css';
import { useState, useEffect } from 'react';
import { Table, TableHead, TableBody, TableRow, TableCell, TableContainer, Paper } from '@mui/material';

function FixedHeaderTable() {
  const [data, setData] = useState([]);

  const fetchDataFromDatabase = () => {
   
    const fakeDataFromDB = [
      { ID: 1, ISBN: '123456789', Titulo: 'Libro 1', Autoria: 'Autor 1' },
      { ID: 2, ISBN: '987654321', Titulo: 'Libro 2', Autoria: 'Autor 2' },
    ];
    setData(fakeDataFromDB);
  };

  useEffect(() => {
    fetchDataFromDatabase();
  }, []);

  return (
    <TableContainer component={Paper} className="table-container" >
      <Table aria-label="fixed header table">
        <TableHead>
          <TableRow className="table-header">
            <TableCell className="table-cell-header">ID</TableCell>
            <TableCell className="table-cell-header">ISBN</TableCell>
            <TableCell className="table-cell-header">Titulo</TableCell>
            <TableCell className="table-cell-header">Autoria</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row) => (
            <TableRow key={row.ID}>
              <TableCell className="table-cell">{row.ID}</TableCell>
              <TableCell className="table-cell">{row.ISBN}</TableCell>
              <TableCell className="table-cell">{row.Titulo}</TableCell>
              <TableCell className="table-cell">{row.Autoria}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default FixedHeaderTable;
