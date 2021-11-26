import React, { useEffect, useState } from 'react';
import './Read.css';
import {Button, Table, Statistic, IconGroup, Icon} from 'semantic-ui-react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import SERVER_URL from '../../utils/constants';


function Read() {
  const [tableData, setTableData] = useState([]);

  const callMockApiWithAxiosGET = () => {
    // const endpointURL = "http://localhost:8080/applicants";
    const endpointURL = `${SERVER_URL}/applicants`;
    axios.get(endpointURL)
      .then(response => setTableData(response.data));
  };

  useEffect(() => {
    callMockApiWithAxiosGET();
  }, []);





  return (

    <div>
      <center>
      <img src={"https://amp.insurancejournal.com/app/uploads/2020/02/allstate-580x392.png"} height="250" width="600px" fluid />
        <h1>All Records of Current Applications</h1>
        <br></br>
        <Statistic>
          <Statistic.Value>
            <Icon name='car' />{tableData.length}
          </Statistic.Value>
          <Statistic.Label>Total Applicants</Statistic.Label>

        </Statistic>
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
            <Table.HeaderCell textAlign={"center"}>Used Outside the Registered State?</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Used for Commercial Purposes?</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>When was the vehicle first registered?</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Current Market Value?</Table.HeaderCell>
            <Table.HeaderCell textAlign={"center"}>Quote Amount</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {
            tableData.map(data => {
              return (
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
              )
            })
          }
        </Table.Body>
      </Table>

      <center>
        <Link to="/admin">
          <Button color="blue" padding="40px"
          >Open Admin Panel</Button>
        </Link>
      </center>
    </div>
  );
}

export default Read;