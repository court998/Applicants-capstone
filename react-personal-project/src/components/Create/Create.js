import React, { useState } from 'react';
import {Form, Button, Flag, Image, Card} from 'semantic-ui-react';
import axios from 'axios';
import './Create.css';
import { useHistory } from 'react-router-dom';
import SERVER_URL from "../../utils/constants";

function Create() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [prefix, setPrefix] = useState('');
  const [telephoneNumber, setTelephoneNumber] = useState('');
  const [addressLine1, setAddressLine1] = useState('');
  const [addressLine2, setAddressLine2] = useState('');
  const [city, setCity] = useState('');
  const [zipcode, setZipcode] = useState('');
  const [vehicleType, setVehicleType] = useState('');
  const [engineSize, setEngineSize] = useState('');
  const [additionalDrivers, setAdditionalDrivers] = useState('');
  const [commercialPurposes, setCommercialPurposes] = useState('');
  const [registeredState, setRegisteredState] = useState('');
  const [currentValue, setCurrentValue] = useState('');
  const [vehicleRegistered, setVehicleRegistered] = useState(null);

  let history = useHistory();

  function formValidation() {
    var validInput = true;
    var error = "";
    var regexNum = /^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s./0-9]*$/;
    var zipcodeRegex = /^[0-9]{5}(?:-[0-9]{4})?$/; //REGEX num that will only accept 5 digits seperated by hyphen accepting a following 4

    if (!prefix.trim()) {
      validInput= false;
      error = "Prefix required to proceed.\n";
    }

    if (!firstName.trim()) {
      validInput = false;
      error += "First Name required to proceed.\n";
    }

    if (!lastName.trim()) {
      validInput = false;
      error += "Last Name required to proceed.\n";
    }
    
    if (!telephoneNumber.match(regexNum) || telephoneNumber.length > 11) {
      validInput = false;
      error += "Telephone Number required to proceed.\n";
    }

    if (!addressLine1.trim()) {
      validInput = false;
      error += "Address Line One required to proceed.\n";
    }


    if (!city.trim()) {
      validInput = false;
      error += "City is required to proceed.\n";
    }

    if(!zipcode.match(zipcodeRegex)){
      validInput = false;
      error += "Zip Code required to proceed and must be presented in the format: 12345-6789\n";
    }

    if (!vehicleType.trim()) {
      validInput = false;
      error += "Vehicle Type is required to proceed.\n";
    }

    if (!engineSize.trim()) {
      validInput = false;
      error += "Engine Size is required to proceed.\n";
    }

    if (!additionalDrivers.trim()) {
      validInput = false;
      error += "Additional Drivers selection required to proceed.\n";
    }

    if (!commercialPurposes.trim()) {
      validInput = false;
      error += "Commercial Purpose selection required to proceed.\n";
    }

    if (!registeredState.trim()) {
      validInput = false;
      error += "Used Outside of State selection is required to proceed.\n";
    }

    if (Date.parse(vehicleRegistered) >= Date.now() || !vehicleRegistered) {
      validInput = false;
      error += "Date is required to proceed and must be not be a future date.\n";
    }//Date.parse(regDate)

    if(!currentValue.trim()){
      validInput = false;
      error += "Current Value required to proceed.";
    } else if(parseInt(currentValue) < 0 || parseInt(currentValue) > 50000){
      validInput = false;
      error += "Current Value must be between $0 and $50,000.\n";
    }

    if (validInput) {
      callMockAPI();
      window.location.href = "/read";
      alert("Form submission successful");
    } else {
      alert("The following records have not been added:\n\n" + error);
      console.log(error);
      return false;
    }

  }


  const callMockAPI = () => {
    console.log(prefix + " " + firstName + " " + lastName + " " + telephoneNumber + "\n" + addressLine1 + " " + addressLine2 + " " + city + " " + zipcode + "\n" +
      vehicleType + " " + engineSize + " " + additionalDrivers + " " + commercialPurposes + " " + registeredState + " " + currentValue + " " + vehicleRegistered);
    
      const formData = {
      prefix,
      firstName,
      lastName,
      telephoneNumber,
      addressLine1,
      addressLine2,
      city,
      zipcode,
      vehicleType,
      engineSize,
      additionalDrivers,
      commercialPurposes,
      registeredState,
      currentValue,
      vehicleRegistered
    }
    // const endpointURL = "http://localhost:8080/applicants";
    const endpointURL = SERVER_URL + "/applicants";
    axios.post(endpointURL, formData)
      .then(() => history.push("/read"))
      .catch(err => console.log(err));
  }

  const prefixOptions = [
    { text: 'Mr', value: 'Mr' },
    { text: 'Miss', value: 'Miss' },
    { text: 'Mrs', value: 'Mrs' },
    { text: 'Ms', value: 'Ms' },
    { text: 'Dr', value: 'Dr' },
  ]

  const vehicleTypeOptions = [
    { text: 'Cabriolet', value: 'Cabriolet' },
    { text: 'Coupe', value: 'Coupe' },
    { text: 'Estate', value: 'Estate' },
    { text: 'Hatchback', value: 'Hatchback' },
    { text: 'Other', value: 'Other' },
  ]

  const engineSizeOptions = [
    { text: '1000', value: '1000' },
    { text: '1600', value: '1600' },
    { text: '2000', value: '2000' },
    { text: '2500', value: '2500' },
    { text: '3000', value: '3000' },
    { text: 'Other', value: 'Other' },
  ]

  const additionalDriversOptions = [
    { text: '0', value: '0' },
    { text: '1', value: '1' },
    { text: '2', value: '2' },
    { text: '3', value: '3' },
    { text: '4', value: '4' },
  ]

  return (

    <div>

      <Form size={"medium"}>

      <center>
        <img src={"https://www.investopedia.com/thmb/O7KjF5XGDvCIF8zWGwLlg3ISh8s=/1910x636/filters:no_upscale()/allstate-insurance-94dd46df295f41e58c22526f98fc5fca.png"} height="150" width="450" alt="allstate-insurance" />  <img src='https://media.istockphoto.com/vectors/protect-car-guard-shield-safety-badge-vehicle-icon-privacy-automobile-vector-id1069246432?k=20&m=1069246432&s=612x612&w=0&h=2mAylC6dMcZxm7OcbyOQqPlQ-xpyufuf5aioTPDQER4=' height="200" width="300px" fluid />
        <h1>Vehicle Insurance Application</h1>
        <p><b>Note:</b> Failure to disclose claims or false declarations will give Allstate certain legal rights, which may include the voiding of your insurance contract and/or refusal of a claim. You may also encounter difficulty in trying to purchase insurance elsewhere. Your quote is guaranteed for 5 days.</p>
      </center><br></br>
      <br></br>

        <h3> Customer Details </h3>
        <Form.Group>
          <Form.Select width={2}  required fluid label='Prefix' options={prefixOptions} placeholder='Prefix' onChange={e => setPrefix(e.target.textContent)} />
          <Form.Input width={6} required fluid label='First Name' placeholder='First Name' maxLength='20' onChange={e => setFirstName(e.target.value)} />
          <Form.Input width={6} required fluid label='Last Name' placeholder='Last Name' maxLength='20' onChange={e => setLastName(e.target.value)} />
          <Form.Input width={4} required fluid label='Telephone Number' placeholder='Telephone Number' maxLength='11' onChange={e => setTelephoneNumber(e.target.value)} />
        </Form.Group>

       <Form.Group>
       <Form.Input width={8} required fluid label='Address Line 1' placeholder='Address Line 1' maxLength='40' onChange={e => setAddressLine1(e.target.value)} />
          <Form.Input width={8} fluid label='Address Line 2' placeholder='Address Line 2' maxLength='40' onChange={e => setAddressLine2(e.target.value)} />

       </Form.Group>

        <Form.Group>
          <Form.Field width={8} required><label>City</label> <input placeholder='City' onChange={e => setCity(e.target.value)} /> </Form.Field>
          <Form.Field width={8} required> <label>Zip Code</label>   <input Flag name='us' placeholder='Zip Code' onChange={e => setZipcode(e.target.value)} /> </Form.Field>
        </Form.Group>

        <h3> Vehicle Details </h3>
        <Form.Group>
          <Form.Select width={6} required fluid label='Select vehicle type' options={vehicleTypeOptions} placeholder='Vehicle Type' onChange={e => setVehicleType(e.target.textContent)} />
          <Form.Select width={6} required fluid label='Select engine size (CC)' options={engineSizeOptions} placeholder='Engine Size' onChange={e => setEngineSize(e.target.textContent)} />
          <Form.Select width={6} required fluid label='Select the amount of additional drivers, maximum 4' options={additionalDriversOptions} placeholder='Additional Drivers'
            onChange={e => setAdditionalDrivers(e.target.textContent)} />
        </Form.Group>

        <Form.Group inline>
          <label>
            Will the vehicle be used outside the registered state?
          </label>
          <Form.Radio width={2}
            fluid label="Yes"
            value="Yes"
            checked={registeredState === "Yes"}
            onChange={() => setRegisteredState("Yes")}
          />
          <Form.Radio width={2}
            fluid label="No"
            value="No"
            checked={registeredState === "No"}
            onChange={() => setRegisteredState("No")}
          />

           <label>
            Will the vehicle be used outside for commericial purposes?
          </label>
          <Form.Radio width={2}
            fluid label="Yes"
            value="Yes"
            checked={commercialPurposes === "Yes"}
            onChange={() => setCommercialPurposes("Yes")}
          />
          <Form.Radio width={2}
            fluid label="No"
            value="No"
            checked={commercialPurposes === "No"}
            onChange={() => setCommercialPurposes("No")}
          />
        </Form.Group>

     

        <Form.Field>
          <label>Date vehicle 1st registered</label>
          <input type="date"
            placeholder="Date registered"
            onChange={(e) => setVehicleRegistered(e.target.value)}
          />
        </Form.Field>

        <Form.Field> <label>Current Value of car in U.S Dollars</label> <input placeholder='Market Value' onChange={e => setCurrentValue(e.target.value)} /> </Form.Field>


          <Button primary
            color='green'
            fluid size='large'
            onClick={formValidation}>Submit

          </Button>


     
      </Form>
    </div>

  );
}
export default Create;