import classes from "./Login.module.css";
import { useNavigate } from "react-router-dom";
import { motion } from "framer-motion";

const Login = ({ setName, name }) => {
  const navigate = useNavigate();

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  return (
    <section className={classes.loginSection}>
      <header className={classes.loginHeader}>
        <h4>
          Tech<span className={classes.color}>Quiz</span>
        </h4>
        <h4
          className={classes.scoreboard}
          onClick={(e) => {
            navigate("/scoreboard");
          }}
        >
          Scoreboard
        </h4>
      </header>
      <form className={classes.loginForm}>
        <div className={classes.inputLogin}>
          <label for="name">Enter your name:</label>
          <input onChange={handleNameChange} id="name" type="text"></input>
        </div>
        <motion.button
          whileHover={{
            transition: {
              type: "just",
            },
            backgroundColor: "#00bfa6",
            width: "13rem",
          }}
          className={classes.btn}
          onClick={(e) => {
            navigate("/category");
          }}
        >
          Enter
        </motion.button>
      </form>
    </section>
  );
};

export default Login;
