import React, { Component } from 'react';
import axios from 'axios';

import './ajaxDemo.css';

class AjaxDemo extends Component {

    state = {
        inputFieldValue: '',
        words: []
    }

    componentDidMount() {
        axios.get('http://localhost:8080/words')
            .then(response => {
                console.log(response);
                this.setState({words: response.data});
            })
            .catch(e => console.warn(e))
    }

    handleChange = (event) => {
        this.setState({inputFieldValue: event.target.value})
    }

    handleSubmit = () => {
        const data = { word: this.state.inputFieldValue };

        axios.post('http://localhost:8080/words', data)
            .then(response => {
                console.log(response);
                this.setState({
                    words: response.data,
                    inputFieldValue: ''
                })
            })
            .catch(e => console.warn(e))
    }

    handleDelete = (id) => {
        axios.delete('http://localhost:8080/words/' + id)
            .then(response => {
                console.log(response);
                this.setState({words: response.data})
            })
            .catch(e => console.warn(e))
    }

    render() {
        return (
            <div>
                <br/>
                <input
                    value={this.state.inputFieldValue}
                    onChange={this.handleChange}
                />
                <button onClick={this.handleSubmit}>Save</button>
                <br/><br/>
                <ul>
                    {this.state.words.map(word =>
                        <div
                            key={word.id}
                            onClick={() => this.handleDelete(word.id)}
                            className='ajax-demo__word-container'
                        >
                            {word.word}
                            </div>
                    )}
                </ul>
            </div>

        )
    }
}

export default AjaxDemo;