import { motion } from "framer-motion";
import { useNavigate } from "react-router-dom";
import classes from "./Finish.module.css";

const Finish = ({ name, score }) => {
  const naviage = useNavigate();

  return (
    <section>
      <motion.img
        whileHover={{ x: -5 }}
        onClick={() => naviage("/")}
        className={classes.pic}
        src={"/assets/back.png"}
      />

      <div>End screen</div>
      <h2>Good job {name}</h2>
      <h3>Your score: {score}</h3>
    </section>
  );
};

export default Finish;
