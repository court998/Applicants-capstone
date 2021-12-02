import React, { useState, useEffect } from 'react';
import './AdminPanel.css';
import { Button, Form } from 'semantic-ui-react';
import 'semantic-ui-css/semantic.min.css';
import axios from 'axios';
import SERVER_URL from "../../utils/constants";
import {useHistory} from 'react-router-dom';

function AdminPanel() {
  const [enteredId, setEnteredId] = useState('');
  const [tableData, setTableData] = useState([]);

  let history = useHistory();

  useEffect(() => {
    // const endpointURL = "http://localhost:8080/applicants";
    const endpointURL = `${SERVER_URL}/applicants`;
    axios.get(endpointURL)
      .then(response => setTableData(response.data));
  }, []);

  function setId(id) { //to set in local storage
    console.log(id);
    localStorage.setItem("id", id);
  }

  function validateID(component) {
    for (var i = 0; i < tableData.length; i++) {
      if (parseInt(enteredId) === parseInt(tableData[i].id)) {
        var match = true;
      }
    }
    if (match) {
      setId(enteredId);
      history.push(component)
    } 
    else {
      alert("The ID entered does not exist. Please enter another.");
    }
  }

  return (
    <div>
      <center>
        <img src={"https://www.investopedia.com/thmb/O7KjF5XGDvCIF8zWGwLlg3ISh8s=/1910x636/filters:no_upscale()/allstate-insurance-94dd46df295f41e58c22526f98fc5fca.png"} height="150" width="450" />  <img src='https://media.istockphoto.com/vectors/protect-car-guard-shield-safety-badge-vehicle-icon-privacy-automobile-vector-id1069246432?k=20&m=1069246432&s=612x612&w=0&h=2mAylC6dMcZxm7OcbyOQqPlQ-xpyufuf5aioTPDQER4=' height="200" width="300px" fluid />
        <h1>Administrator Panel</h1>
        <h3>Enter an applicant ID below to access and modify</h3>

        <br></br>
      </center>
      <Form size={"large"}>
        <Form.Group>
          <Form.Input maxLength='5' width={16} fluid label='Enter ID' placeholder='Applicant ID' onChange={e => setEnteredId(e.target.value)} />
        </Form.Group>
        <center>
          <Button
              color="blue"
              padding="40px"
              onClick={() => validateID("/get")}
          >View Record</Button>

          <Button
              color="grey"
              padding="40px"
              onClick={() => validateID("/update")}
          >Update Record</Button>

          <Button
              color="red"
              padding="40px"
              onClick={() => validateID("/delete")}
          >Delete Record</Button>


        </center>
      </Form>
    </div>
  );

}
export default AdminPanel;