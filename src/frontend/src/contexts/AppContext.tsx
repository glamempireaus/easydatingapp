import React, { useState, useEffect, createContext, ReactNode, FC } from 'react';

interface IAppContext {
    isLoggedIn: boolean,
    setIsLoggedIn: (payload: boolean) => void;

    userToken: string,
    setUserToken: (payload: string) => void;
}

const defaultState = {
    setIsLoggedIn: () => null,
    setUserToken: () => null,
    isLoggedIn: false,
    userToken: "",
}

export const AppContext = React.createContext<IAppContext>(defaultState);

type AppProviderProps = {
    children?: ReactNode;
};

export const AppProvider: FC<AppProviderProps> = ({ children }) => {
    const [isLoggedIn, setIsLoggedIn] = React.useState(defaultState.isLoggedIn);
    const [userToken, setUserToken] = React.useState(defaultState.userToken);

    // example of function
    /*    const toggleIsLoggedIn = () => {
            setIsLoggedIn(!isLoggedIn);
        };*/

    return (
        <AppContext.Provider
            value={{
                isLoggedIn,
                setIsLoggedIn,
                userToken,
                setUserToken,
            }}
        >
            {children}
        </AppContext.Provider>
    );
};

export default AppContext;