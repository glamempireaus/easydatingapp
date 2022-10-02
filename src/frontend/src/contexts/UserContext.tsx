import React, { useState, useEffect, createContext } from 'react';

const defaultState = {
    firstName: "",
    lastName: ""
};

const UserContext = createContext(defaultState);

export default UserContext;
