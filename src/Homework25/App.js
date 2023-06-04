import logo from './logo.png';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="Devmind Logo" />
        <p>
          Welcome! This is my first React app!
        </p>
        <a
          className="App-link"
          href="https://www.devmind.ro"
          target="_blank"
          rel="noopener noreferrer"
        >
        Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
