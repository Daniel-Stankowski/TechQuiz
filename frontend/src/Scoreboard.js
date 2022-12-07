import { useNavigate } from "react-router-dom";
import classes from "./Scoreboard.module.css";

const Scoreboard = () => {
  const navigate = useNavigate();

  const DUMMT_DATA = [
    { name: "John", score: 200, category: "html" },
    { name: "Frank", score: 300, category: "html" },
    { name: "Bob", score: 400, category: "html" },
    { name: "Anna", score: 600, category: "html" },
    { name: "Hania", score: 350, category: "html" },
  ];

  DUMMT_DATA.sort((a, b) => b.score - a.score);

  return (
    <section>
      <header className={classes.scoreboardHeader}>
        <div
          className={classes.back}
          onClick={(e) => {
            navigate("/");
          }}
        >
          Back
        </div>
      </header>

      <article className={classes.scoreboard}>
        <h2>Scoreboard</h2>

        {DUMMT_DATA.map((item) => {
          return (
            <article className={classes.scoreItem}>
              <div>{item.name}</div>
              <div>{item.score}</div>
            </article>
          );
        })}
      </article>
    </section>
  );
};

export default Scoreboard;
