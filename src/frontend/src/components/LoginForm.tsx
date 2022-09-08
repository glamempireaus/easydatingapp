import { useRef, useState } from "react";
import loginUser from "rest/loginUser";
import './LoginForm.css';

const LoginForm = () => {
    const [message, setMessage] = useState<string>("");
    const loginForm = useRef<HTMLFormElement>(null);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const formData = new FormData(loginForm.current!);

        const email = formData.get('email') as string;
        const password = formData.get('password') as string;

        const returnCode = await loginUser(email, password);

        setMessage(returnCode[1]);

        // on successful login

        if (returnCode[0] == 0) {
            //isLoggedIn = true;
        }
    }
    return (
        <div className="LoginForm">
            {message}
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