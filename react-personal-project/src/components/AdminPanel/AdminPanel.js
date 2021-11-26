import React, { useState, useEffect } from 'react';
import './AdminPanel.css';
import { Button, Form } from 'semantic-ui-react';
import 'semantic-ui-css/semantic.min.css';
import axios from 'axios';
import SERVER_URL from "../../utils/constants";

function AdminPanel() {
  const [enteredId, setEnteredId] = useState('');
  const [tableData, setTableData] = useState([]);

  useEffect(() => {
    // const endpointURL = "http://localhost:8080/applicants";
    const endpointURL = `${SERVER_URL}/applicants`;
    axios.get(endpointURL)
      .then(response => setTableData(response.data));
  }, []);

  function setIdInLocalStorage(id) {
    console.log(id);
    localStorage.setItem("id", id);
  }

  function checkIfIdIsValid(component) {
    for (var i = 0; i < tableData.length; i++) {
      if (parseInt(enteredId) === parseInt(tableData[i].id)) {
        var equals = true;
      }
    }
    if (equals) {
      setIdInLocalStorage(enteredId);
      window.location.href = component;
    } 
    else {
      alert("The ID entered does not exist. Please enter another.");
    }
  }

  return (
    <div>
      <center>
        <img src={"https://www.investopedia.com/thmb/O7KjF5XGDvCIF8zWGwLlg3ISh8s=/1910x636/filters:no_upscale()/allstate-insurance-94dd46df295f41e58c22526f98fc5fca.png"} height="150" width="450" alt="allstate-insurance" />
        <h1>Administrator Panel</h1>
        <h3>Enter an applicant id below to access and modify</h3>

        <br></br>
      </center>
      <Form size={"large"}>
        <Form.Group>
          <Form.Input maxLength='3' width={16} fluid label='Enter ID' placeholder='Enter ID' onChange={e => setEnteredId(e.target.value)} />
        </Form.Group>
        <center>
          <Button
              color="blue"
              padding="40px"
              onClick={() => checkIfIdIsValid("/get")}
          >View Record</Button>

          <Button
              color="green"
              padding="40px"
              onClick={() => checkIfIdIsValid("/update")}
          >Update Record</Button>

          <Button
              color="red"
              padding="40px"
              onClick={() => checkIfIdIsValid("/delete")}
          >Delete Record</Button>


        </center>
      </Form>
    </div>
  );

}
export default AdminPanel;