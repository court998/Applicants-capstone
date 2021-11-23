import React, { useState, useEffect } from 'react';
import { Button, Form } from 'semantic-ui-react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function Update() {
  const [data, setData] = useState([]);
  const [id, setId] = useState(null);
  const [telephoneNumber, setTelephoneNumber] = useState('');

  useEffect(
    () => {
      setId(localStorage.getItem('id'));
    }, []
  )


  function validatePhoneNumber(eNumber) {
    var regexNum = /^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s./0-9]*$/;
    if (eNumber.match(regexNum) && eNumber.length > 10) {
      setTelephoneNumber(eNumber);
      callMockAPI();
      window.location.href = "/admin";
      alert("Record  successfully updated");

      return true;
    }
    else {
      alert("Telephone number must be entered in the correct format. ");
      return false;
    }
  }

  useEffect(
    () => {
      if(id === null)
      {
        return;
      }
      else{
        const endpointURL = `http://localhost:8080/applicants/id?id=${id}`;
    axios.get(endpointURL)
    .then(response => setData(response.data));
    console.log("valid call");
      }
    
    }, [id],
  )

  const callMockAPI = () => {
    console.log(id + " " + telephoneNumber);
    const formData = {
      telephoneNumber
    }
    const endpointURL = `http://localhost:8080/applicants?id=${id}&telephoneNumber=${telephoneNumber}`;
    axios.put(endpointURL, formData)
      .then(() => alert("Record Updated"))
      .catch(err => console.log(err));
  }

  return (
    <div>
      <center>
        <img src={"https://www.investopedia.com/thmb/O7KjF5XGDvCIF8zWGwLlg3ISh8s=/1910x636/filters:no_upscale()/allstate-insurance-94dd46df295f41e58c22526f98fc5fca.png"} height="150" width="450" alt="allstate-insurance" />
        <h1>Update a Record</h1>
        <br></br>
      </center>
      <Form>
        <Form.Field>
          <label>ID</label>
          <input
            readOnly={true}
            type="text"
            name="id"
            placeholder='ID'
            value={data.id}
          />
        </Form.Field>
        <Form.Field>
          <label>First Name</label>
          <input
            readOnly={true}
            type="text"
            name="firstName"
            placeholder='First Name'
            value={data.firstName}
          />
        </Form.Field>
        <Form.Field>
          <label>Last Name</label>
          <input
            readOnly={true}
            type="text"
            name="lastName"
            placeholder='Last Name'
            value={data.lastName}
          />
        </Form.Field>
        <Form.Field>
          <label>Telehone Number</label>
          <input
            name="telephoneNumber"
            placeholder='Phone Number'
            maxLength='11'
            onChange={e => setTelephoneNumber(e.target.value)}
            defaultValue={data.telephoneNumber}
          />
        </Form.Field>
      </Form>
      <center>
        <br></br>
        <Link to="/admin">
          <Button color="blue"
          >Return to Admin Panel</Button>
        </Link>
        <Button
          color="green"
          onClick={e => validatePhoneNumber(telephoneNumber)}
        >Update
        </Button>
        <Link to="/read">
          <Button color="yellow"
          >View all Records</Button>
        </Link>
      </center>

    </div>
  );
}
export default Update;