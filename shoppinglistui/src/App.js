import './App.css';
import AppBar from "./Appbar";
import Table from "./Table"
import { useEffect,useState } from 'react';
import axios from "axios"



function App() {
  const [data,setData] = useState({})

  useEffect(() => {
     const fetchData = async () => {
      try {
        const response = await axios.get('https://8081-thinh901-verteilesystem-j5dcxegg38p.ws-eu106.gitpod.io/shopping'); // Replace with your API endpoint
        setData(response.data);
        console.log(response.data)
      } catch (error) {
        console.log("alsch")
        // Handle errors as needed, for example, set an error state
      }
    };

    fetchData(); // Call the fetchData function when the component mounts
  },[])
  return (
    <> 
      <AppBar/>
      <Table/>
    </>
  );
}

export default App;
