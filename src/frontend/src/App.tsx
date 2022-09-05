import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

type AppProps = {
  children?: React.ReactNode;
};

function App({ children }: AppProps) {
  const [status, setStatus] = useState("");
  const [message, setMessage] = useState("");

  return (
    <div className="App">
      <header className="App-header">
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
      </header>
      <a
        className="App-link"
        href="https://reactjs.org"
        target="_blank"
        rel="noopener noreferrer"
      >
        Learn React
      </a>
      {children}
    </div>
  );
}

export default App;
