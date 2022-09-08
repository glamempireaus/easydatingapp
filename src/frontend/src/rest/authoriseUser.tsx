import { useRef, useState } from "react";

const authoriseUser = async (email: string, password: string) => {

    var errorMessage: string;

    const requestBody = {
        email: email,
        password: password,
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
            errorMessage = "You have authorised in successfully.";
            break;
        case 1:
            errorMessage = "sessionId is empty.";
            break;
        case 2:
            errorMessage = "sessionId is invalid.";
            break;
        case 100:
            errorMessage = "There's a problem with our database. Try again later.";
            break;
        default:
            errorMessage = "There's a problem with our backend server. Try again later.";
    }

    return [returnedData.errorCode, errorMessage];
}

export default authoriseUser;