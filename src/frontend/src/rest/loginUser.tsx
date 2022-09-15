import { useRef, useState } from "react";



const loginUser = async (email: string, password: string) => {

    const requestBody = {
        email: email,
        password: password,
    }

    // attempt to fetch login

    var response: any;
    try {
        response = await fetch('http://localhost:8080/easydatingapp/api/loginUser', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(requestBody)
        });
    }
    catch (error) {
        const message = "Can't connect to backend. Please try again later!";
        const errorCode = 100;
        return { errorCode: errorCode, message: message };
    }

    // check if response code isn't 200

    if (!response.ok) {
        const message = "Can't connect to backend. Please try again later!";
        const errorCode = 100;
        return { errorCode: errorCode, message: message };
    }

    // get fetched data as json

    const returnedData = response.json();

    return returnedData;
}

export default loginUser;