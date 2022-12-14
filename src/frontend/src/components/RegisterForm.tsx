import { useRef, useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import { Cookies } from "react-cookie";
import RestCalls from "rest/RestCalls";
import './RegisterForm.css';
import AppConstants from '../contexts/Data';
import AppContext, { AppProvider } from '../contexts/AppContext';

const RegisterForm = () => {
    const [message, setMessage] = useState<string>("");
    const navigate = useNavigate();
    const cookies = new Cookies();
    const appContext = useContext(AppContext);

    const registerForm = useRef<HTMLFormElement>(null);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        // get form's data

        const formData = new FormData(registerForm.current!);

        const email = formData.get('email') as string;
        const password = formData.get('password') as string;
        const firstName = formData.get('firstname') as string;
        const lastName = formData.get('lastname') as string;

        // attempt register (hang)

        const response = await RestCalls.registerUser(email, password, firstName, lastName);

        // handle response
        switch (response.errorCode) {
            case 0:
                setMessage("You have registered successfully.");

                cookies.set("isLoggedIn", "true", {
                    path: "/"
                });

                appContext.setIsLoggedIn(true);
                appContext.setUserToken(response.sessionToken);

                setTimeout(() => navigate(AppConstants.HOME_URL), 500);

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