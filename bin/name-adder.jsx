var React = require('react');
var ReactDOM = require('react-dom');

class NameAdder extends React.Component {
    handleSubmit(event) {
        event.preventDefault()

        var input = ReactDOM.findDOMNode(this.refs.input)

        fetch(`${this.props.url}/${input.value}`, {method: 'POST'})
            .then(response => {
                if(response.ok) {
                    input.value = null
                    this.props.onAdded()
                }
            })
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit.bind(this)}>
                <input ref="input"/>
                <button>add name</button>
            </form>
        )
    }
}

module.exports = NameAdder