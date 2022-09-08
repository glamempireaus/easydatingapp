import { useRef, useState } from "react";
import registerUser from "rest/registerUser";
import './RegisterForm.css';

const RegisterForm = () => {
    const [message, setMessage] = useState<string>("");
    const registerForm = useRef<HTMLFormElement>(null);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const formData = new FormData(registerForm.current!);

        const email = formData.get('email') as string;
        const password = formData.get('password') as string;
        const firstName = formData.get('firstname') as string;
        const lastName = formData.get('lastname') as string;

        const returnCode = await registerUser(email, password, firstName, lastName);

        setMessage(returnCode[1]);

        // on successful register

        if (returnCode[0] == 0) {
            //isLoggedIn = true;
        }
    }
    return (
        <div className="RegisterForm">
            {message}
            <form id="registerForm" ref={registerForm} onSubmit={handleSubmit} >
                <label htmlFor="email">Email:</label>
                <input defaultValue="hello@gmail.com" type="text" id="email" name="email" />
                <br />
                <label htmlFor="password">Password:</label>
                <input defaultValue="hello123" type="password" id="password" name="password" />
                <br />
                <label htmlFor="firstname">First Name:</label>
                <input defaultValue="bodhi" type="text" id="firstname" name="firstname" />
                <br />
                <label htmlFor="lastname">Last name:</label>
                <input defaultValue="asdasd" type="text" id="lastname" name="lastname" />
                <br />
                <input type="submit" />
            </form>
        </div>
    )
}

export default RegisterForm;