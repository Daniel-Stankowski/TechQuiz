import { useState } from "react";
import classes from "./Login.module.css";
import { useNavigate } from "react-router-dom";

const Login = ({ setName, name }) => {
  const navigate = useNavigate();

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  return (
    <section className={classes.loginSection}>
      <header className={classes.loginHeader}>
        <div>TechQuiz</div>
        <div>Scoreboard</div>
      </header>
      <form>
        <label for="name">Podaj nazwę:</label>
        <input onChange={handleNameChange} id="name" type="text"></input>
        <button
          onClick={(e) => {
            navigate("/category");
          }}
        >
          Enter
        </button>
      </form>
    </section>
  );
};

export default Login;
