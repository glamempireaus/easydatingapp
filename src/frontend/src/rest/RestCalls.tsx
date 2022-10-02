class RestCalls {

    static endpointUrl = "http://localhost:8080/easydatingapp/api";

    static fetchRequest = async (endpointCall: string, requestBody: any) => {

        var response: any;
        try {
            response = await fetch(this.endpointUrl + endpointCall, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(requestBody)
            });
        }
        catch (error) {
            return {
                errorCode: "Can't connect to backend. Please try again later!",
                message: 100
            };
        }

        // check if response code isn't 200

        if (!response.ok) {
            return {
                errorCode: "Response code error. Please try again later!",
                message: 100
            };
        }

        // get fetched data as json

        const returnedData = response.json();

        return returnedData;
    }

    // register user
    static registerUser = async (email: string, password: string, firstname: string, lastname: string) => {

        const requestBody = {
            email: email,
            password: password,
            firstName: firstname,
            lastName: lastname
        }

        const returnedData = await this.fetchRequest('/registerUser', requestBody);

        return returnedData;
    }

    // login user
    static loginUser = async (email: string, password: string) => {

        const requestBody = {
            email: email,
            password: password,
        }

        const returnedData = await this.fetchRequest('/loginUser', requestBody);

        return returnedData;
    }
}

export default RestCalls;