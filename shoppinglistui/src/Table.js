import * as React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import axios from "axios"
import { Checkbox,Button } from "@mui/material";

export default function BasicTable(props) {
  const { shoppingList, updateItemStatus, deleteItem,baseUrl } = props;



  const handleDelete = async (id) => {
    try {
      // Send a DELETE request to your server to delete the item
      await axios.delete(`${baseUrl}/shopping/${id}`);

      // Call the parent component's function to update the local state
      deleteItem(id);
    } catch (error) {
      console.error(error);
      // Handle errors as needed
    }
  };

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Title</TableCell>
            <TableCell align="right">Description</TableCell>
            <TableCell align="right">Done</TableCell>
            <TableCell align="right">Action</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {shoppingList.map((item) => (
            <TableRow
              key={item.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {item.title}
              </TableCell>
              <TableCell align="right">{item.description}</TableCell>
              <TableCell align="right">
                <Checkbox
                  checked={item.done}
                />
              </TableCell>
              <TableCell align="right">
                <Button variant="outlined" color="error" onClick={() => handleDelete(item.id)}>
                  Delete
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
