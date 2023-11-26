import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Button, Checkbox, TextField, Select, MenuItem } from '@mui/material';
import AppBar from './Appbar';
import Table from './Table';

function App() {
  const [data, setData] = useState([]);
  const [newItem, setNewItem] = useState({
    title: '',
    description: '',
    done: false,
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8081/shopping');
        setData(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchData();
  }, []);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setNewItem((prevNewItem) => ({
      ...prevNewItem,
      [name]: value,
    }));
  };

  const addNewItem = async () => {
    try {
      const response = await axios.post('http://localhost:8081/shopping', newItem);
      setData((prevData) => [...prevData, response.data]);
      setNewItem({
        title: '',
        description: '',
        done: false,
      });
    } catch (error) {
      console.error(error);
    }
  };


  const deleteItem = async (id) => {
    try {
      await axios.delete(`http://localhost:8081/shopping/${id}`);
      setData((prevData) => prevData.filter((item) => item.id !== id));
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <>
      <AppBar />
      <Table shoppingList={data} deleteItem={deleteItem} />

      <TextField
        label="Title"
        variant="outlined"
        name="title"
        value={newItem.title}
        onChange={handleChange}
        style={{ margin: '8px' }}
      />
      <TextField
        label="Description"
        variant="outlined"
        name="description"
        value={newItem.description}
        onChange={handleChange}
        style={{ margin: '8px' }}
      />
      <Select
        label="Done"
        variant="outlined"
        name="done"
        value={newItem.done}
        onChange={handleChange}
        style={{ margin: '8px' }}
      >
        <MenuItem value={false}>Not Done</MenuItem>
        <MenuItem value={true}>Done</MenuItem>
      </Select>

      {/* Button to add a new item */}
      <Button variant="contained" onClick={addNewItem}>
        Add New Item
      </Button>
    </>
  );
}

export default App;
