import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";

class App extends Component {
  state = {
    text: "initialText",
  };

  componentDidMount() {
      axios.get('/hello')
          .then(({data}) =>
            this.setState({text: data})
          );
  }

  render() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <h2>{this.state.text}</h2>
      </header>
    </div>
  );
}
}

export default App;
