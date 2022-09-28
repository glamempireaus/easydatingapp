import { useRef, useState } from "react";
import './MainMenu.css';
import { useNavigate } from "react-router-dom";
import { Cookies } from "react-cookie";

import { Link } from "react-router-dom";

import AppConstants from '../contexts/Data';

type MainMenuProps = {
    dataLeft?: string[][]; // title, link
    dataRight?: string[][]; // title, link
};

const MainMenu = (props: MainMenuProps) => {

    const navigate = useNavigate();
    const cookies = new Cookies();

    if (props.dataLeft == null) {

    }

    const handleLogout = (e: any) => {
        e.preventDefault();

        navigate(AppConstants.LOGOUT_URL);
    }

    return (
        <div className="MainMenu container">
            {props.dataLeft != null && props.dataLeft.map(menuDataInstance => (
                <Link to={menuDataInstance[1]}> {menuDataInstance[0]} </Link>
            ))}

            {props.dataRight != null && props.dataRight.map(menuDataInstance => (
                <Link to={menuDataInstance[1]} style={{ marginLeft: "auto" }} > {menuDataInstance[0]} </Link>
            ))}
        </div>
    )
}

MainMenu.defaultProps = {
    dataLeft: [["Browse Matches", AppConstants.HOME_URL], ["Messages", AppConstants.MESSAGES_URL], ["My Profile", AppConstants.PROFILE_URL]],
    dataRight: [["Logout", AppConstants.LOGOUT_URL]]
}

export default MainMenu;