import "./App.css";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<div>Page1</div>} />
        <Route path="/category" element={<div>Page1</div>} />
        <Route path="/quiz" element={<div>Page1</div>} />
      </Routes>
    </div>
  );
}

export default App;
