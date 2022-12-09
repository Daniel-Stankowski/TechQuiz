import { motion } from "framer-motion";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import classes from "./Finish.module.css";

const Finish = ({ name, score, category }) => {
  const naviage = useNavigate();
  useEffect(() => {
    const sendScore = async () => {
      await fetch("http://localhost:8080/score", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username: name, category, score }),
      });
    };
    sendScore();
  }, []);

  return (
    <section className={classes.sec}>
      <motion.img
        whileHover={{ x: -5 }}
        onClick={() => naviage("/")}
        className={classes.pic}
        src={"/assets/back.png"}
      />

      <h2>
        Good job <span className={classes.name}>{name}</span>
      </h2>
      <h3 className={classes.score}>Your score: {score}</h3>
    </section>
  );
};

export default Finish;
