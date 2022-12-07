import "./App.css";
import { Routes, Route } from "react-router-dom";
import Login from "./Login";
import { useState } from "react";
import Authorized from "./Authorized";
import Scoreboard from "./Scoreboard";
import CategoriesList from "./CategoriesList";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [name, setName] = useState("");

  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Login setName={setName} name={name} />} />
        <Route
          path="/category"
          element={name === "" ? <Authorized /> : <CategoriesList />}
        />

        <Route path="/quiz/:category" element={<div>Page1</div>} />
        <Route path="/scoreboard" element={<Scoreboard />} />
      </Routes>
    </div>
  );
}

export default App;
