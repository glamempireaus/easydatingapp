import { useRef, useState } from "react";

const registerUser = async (email: string, password: string, firstname: string, lastname: string) => {

    var errorMessage: string;

    const requestBody = {
        email: email,
        password: password,
        firstName: firstname,
        lastName: lastname
    }

    const response = await fetch('http://localhost:8080/easydatingapp/api/registerUser', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(requestBody)
    });

    if (!response.ok) {
        errorMessage = "Can't connect to backend. Please try again later!";
    }

    const returnedData = await response.json();

    switch (returnedData.errorCode) {
        case 0:
            errorMessage = "You have registered successfully.";
            break;
        case 1:
            errorMessage = "Email is invalid.";
            break;
        case 2:
            errorMessage = "Password is invalid.";
            break;
        case 3:
            errorMessage = "Firstname is invalid.";
            break;
        case 4:
            errorMessage = "Lastname is invalid.";
            break;
        case 5:
            errorMessage = "This email already exists. Please try logging in.";
            break;
        case 100:
            errorMessage = "There's a problem with our database. Try again later.";
            break;
        default:
            errorMessage = "There's a problem with our backend server. Try again later.";
    }

    return [returnedData.errorCode, errorMessage];
}

export default registerUser;