var React = require('react'),
    ReactDOM = require('react-dom'),
    NameAdder = require('./name-adder.jsx'),
    NamesList = require('./names-list.jsx');

class NameManager extends React.Component {
    handleNameAdded() {
        this.refs.namesList.update()
    }

    render() {
        return (
            <div>
                <NameAdder url="/name" onAdded={this.handleNameAdded.bind(this)}/>
                <NamesList url="/names" ref="namesList"/>
            </div>
        )
    }
}

ReactDOM.render(<NameManager/>, document.querySelector('#demo'))