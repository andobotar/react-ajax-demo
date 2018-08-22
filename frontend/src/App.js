import React, {Component} from 'react';
import './App.css';
// import SockJsClient from 'react-stomp';
import AjaxDemo from "./components/AjaxDemo";

class App extends Component {

    render() {
        return (
            <div className="App">

                <AjaxDemo />

                {/*<SockJsClient
                    url='http://localhost:8080/handler' topics={['/topic/kutza']}
                    onMessage={(msg) => { console.log(msg); }}
                    // ref={ (client) => { this.clientRef = client }}
                />*/}

            </div>
        );
    }
}

export default App;
