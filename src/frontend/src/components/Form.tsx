import { useRef, useState } from "react";

type FormProps = {
    color: string;
    children?: React.ReactNode;
};

const Form = () => {
    const [message, setMessage] = useState<string>("");
    const form = useRef<HTMLFormElement>(null);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        const formData = new FormData(form.current!);

        console.log(formData);

        const response = await fetch('http://localhost:8080/easydatingapp/api/registerUser', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(Object.fromEntries(formData))
        });

        if (!response.ok) {
            setMessage("Can't connect to backend. Please try again later!");
        }

        const returnedData = await response.json();

        switch (returnedData.errorCode) {
            case 0:
                setMessage("You have registered successfully.")
                break;
            case 1:
                setMessage("Email is invalid.");
                break;
            case 2:
                setMessage("Password is invalid.");
                break;
            case 3:
                setMessage("Firstname is invalid.");
                break;
            case 4:
                setMessage("Lastname is invalid.");
                break;
            case 5:
                setMessage("This email already exists. Please try logging in.");
                break;
            case 100:
                setMessage("There's a problem with our database. Try again later.");
                break;
            default:
                setMessage("There's a problem with our backend server. Try again later.");
        }

    }
    return(
        <div>
            <p>{message}</p>
            <form ref={form} onSubmit={handleSubmit} >
                <label htmlFor="email">Email:</label>
                <input defaultValue="hello@gmail.com" type="text" id="email" name="email"/>
                <br/>
                <label htmlFor="password">Password:</label>
                <input defaultValue="hello123" type="password" id="password" name="password"/>
                <br/>
                <label htmlFor="firstName">First Name:</label>
                <input defaultValue="bodhi" type="text" id="firstName" name="firstName"/>
                <br/>
                <label htmlFor="lastName">Last name:</label>
                <input defaultValue="judd" type="text" id="lastName" name="lastName"/>
                <br/>
                <input type="submit"/>
            </form>
        </div>
        );
}

export default Form;