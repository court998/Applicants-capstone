import React, { useEffect, useState } from 'react';
import { Button, Table } from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import SERVER_URL from "../../utils/constants";

function Get() {
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

      }
      else{
        // const endpointURL = `http://localhost:8080/applicants/id?id=${id}`;
        const endpointURL = `${SERVER_URL}/applicants/id?id=${id}`;
    axios.get(endpointURL)
    .then(response => setData(response.data));
    console.log("Success");
      }

    }, [id],
  )

  return (
    <div>
      <center>
        <img src={"https://www.investopedia.com/thmb/O7KjF5XGDvCIF8zWGwLlg3ISh8s=/1910x636/filters:no_upscale()/allstate-insurance-94dd46df295f41e58c22526f98fc5fca.png"} height="150" width="450" />
        <h1>Current Applications</h1>
        <br></br>
      </center>
      <Table celled>
        <Table.Header>
          <Table.Row>
          <Table.HeaderCell textAlign={"center"}>ID Number</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Prefix</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>First Name</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Last Name</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Phone Number</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Address</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Vehicle Type</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Engine Size (CC)</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Number of Additional Drivers</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Used Outside the Registered State</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Used for Commercial Purposes</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>When was the vehicle first registered?</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Current Market Value?</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Quote Amount</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          <Table.Row>
          <Table.Cell width={1} textAlign={"center"}>{data.id}</Table.Cell>
            <Table.Cell width={1} textAlign={"center"}>{data.prefix}</Table.Cell>
            <Table.Cell textAlign={"center"}>{data.firstName}</Table.Cell>
            <Table.Cell textAlign={"center"}>{data.lastName}</Table.Cell>
            <Table.Cell textAlign={"center"}>{data.telephoneNumber}</Table.Cell>
            <Table.Cell textAlign={"center"}>{data.addressLine1}<br />{data.addressLine2}<br />{data.city}<br />{data.zipcode}</Table.Cell>
            <Table.Cell width={1} textAlign={"center"}>{data.vehicleType}</Table.Cell>
            <Table.Cell width={1} textAlign={"center"}>{data.engineSize}</Table.Cell>
            <Table.Cell width={1} textAlign={"center"}>{data.additionalDrivers}</Table.Cell>
            <Table.Cell width={1} textAlign={"center"}>{data.registeredState}</Table.Cell>
            <Table.Cell width={1} textAlign={"center"}>{data.commercialPurposes}</Table.Cell>
            <Table.Cell width={2} textAlign={"center"}>{data.vehicleRegistered}</Table.Cell>
            <Table.Cell width={2} textAlign={"center"}>${data.currentValue}</Table.Cell>
            <Table.Cell width={3} textAlign={"center"}>${data.quoteAmount}</Table.Cell>
          </Table.Row>
        </Table.Body>
      </Table>

      <center>
        <Link to="/admin">
          <Button color="blue" padding="40px"
          >Return Admin Panel</Button>
        </Link>

        <Link to="/read">
          <Button color="grey" padding="40px"
          >View all Records</Button>
        </Link>


      </center>
    </div>
  );
}

export default Get;