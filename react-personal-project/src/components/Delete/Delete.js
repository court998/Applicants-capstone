import React, { useEffect, useState } from 'react';
import './Delete.css';
import { Button, Table, Card, Icon, Image } from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import SERVER_URL from "../../utils/constants";

function Delete() {
  const [data, setData] = useState([]);
  const [id, setId] = useState(null);

  useEffect(
    () => {
      setId(localStorage.getItem('id'));
    }, [],
  )

  
  useEffect(
    () => {
      if(id === null)
      {
        return;
      }
      else{
        // const endpointURL = `http://localhost:8080/applicants/id?id=${id}`;
        const endpointURL = `${SERVER_URL}/applicants/id?id=${id}`;
    axios.get(endpointURL)
    .then(response => setData(response.data));
    console.log("valid call");
      }
    
    }, [id],
  )

  const onDelete = (id) => {
    // const endpointURL = `http://localhost:8080/applicants?id=${id}`;
    const endpointURL = `${SERVER_URL}/applicants?id=${id}`;
    axios.delete(endpointURL)
      .then(() => del())
      .catch(
        (err) => { console.log(err) }
      );
  }

  function del() {
    alert("Record successfully deleted.");
    window.location.href = "/read";
  }

  return (
    <div>
      <center>
        <img src={"https://www.investopedia.com/thmb/O7KjF5XGDvCIF8zWGwLlg3ISh8s=/1910x636/filters:no_upscale()/allstate-insurance-94dd46df295f41e58c22526f98fc5fca.png"} height="150" width="450"/>
        <h1>Delete an Application</h1>
        <br></br>

      <Card>
        <Image src='https://media.istockphoto.com/vectors/protect-car-guard-shield-safety-badge-vehicle-icon-privacy-automobile-vector-id1069246432?k=20&m=1069246432&s=612x612&w=0&h=2mAylC6dMcZxm7OcbyOQqPlQ-xpyufuf5aioTPDQER4=' wrapped ui={false} />
        <Card.Content>
          <Icon name='user' />
          <Card.Header>{data.prefix} {data.firstName} {data.lastName}</Card.Header>
          <Card.Meta>Car registered: {data.vehicleRegistered}<br></br>
            Address: {data.addressLine1}, {data.addressLine2} <br></br>Vehicle Type: {data.vehicleType}</Card.Meta>
          <Card.Description>
            Current Value: ${data.currentValue}
          </Card.Description>
        </Card.Content>
        <Card.Content extra>
          <a>
            <Card.Header>Quote Total:</Card.Header>
            <Icon name='dollar sign' />
            {data.quoteAmount}
          </a>
        </Card.Content>
      </Card>
      </center>
      <br></br>


      <center>
        <Link to="/admin">
          <Button color="blue"
          >Return to Admin Panel</Button>
        </Link>

        <Link to="/read">
          <Button color="yellow"
          >View all Records</Button>
        </Link>
        <Button color="red"
          onClick={() => onDelete(data.id)}>Delete
        </Button>

      </center>
    </div>
  );
}

export default Delete;