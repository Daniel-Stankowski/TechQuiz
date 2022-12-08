import { useNavigate } from "react-router-dom";
import classes from "./Authorized.module.css";
import { motion } from "framer-motion";

const Authorized = () => {
  const naviage = useNavigate();

  return (
    <>
      <motion.img
        whileHover={{ x: -5 }}
        onClick={() => naviage("/")}
        className={classes.pic}
        src={"/assets/back.png"}
      />
      <article className={classes.article}>
        <h3>
          You need to enter your <span className={classes.outline}>name</span>{" "}
          first to start the game
        </h3>
        <img src="/assets/fot1.svg" />
      </article>
    </>
  );
};

export default Authorized;
