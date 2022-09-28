import { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import RestCalls from "rest/RestCalls";
import './LoginForm.css';
import { Cookies } from "react-cookie";
import AppConstants from '../contexts/Data';

const LoginForm = () => {
    const [message, setMessage] = useState<string>("");
    const loginForm = useRef<HTMLFormElement>(null);
    const navigate = useNavigate();
    const cookies = new Cookies();

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        // get form data

        const formData = new FormData(loginForm.current!);

        const email = formData.get('email') as string;
        const password = formData.get('password') as string;

        // attempt login (hang)

        const response = await RestCalls.loginUser(email, password);

        switch (response.errorCode) {
            case 0:
                setMessage("You have logged in successfully.");

                // set session token cookies

                if (response.errorCode == 0) {
                    cookies.set("sessionToken", response.sessionToken, {
                        path: "/"
                    });
                    cookies.set("isLoggedIn", true, {
                        path: "/"
                    });
                }

                // navigate to main after timeout (to show message)

                setTimeout(() => navigate(AppConstants.HOME_URL), 500);

                break;
            case 1:
                setMessage("Email is empty.");
                break;
            case 2:
                setMessage("Password is invalid.");
                break;
            case 3:
                setMessage("Email is invalid.");
                break;
            case 100:
                setMessage("There's a problem with our database. Try again later.");
                break;
            default:
                setMessage("There's a problem with our backend server. Try again later.");
        }
    }
    return (
        <div className="LoginForm">
            <p className="LoginFormMessage">{message}</p>
            <form id="loginform" ref={loginForm} onSubmit={handleSubmit} >
                <label htmlFor="email">Email:</label>
                <input defaultValue="hello@gmail.com" type="text" id="email" name="email" />
                <br />
                <label htmlFor="password">Password:</label>
                <input defaultValue="hello123" type="password" id="password" name="password" />
                <br />
                <input type="submit" />
            </form>
        </div>
    )
}

export default LoginForm;