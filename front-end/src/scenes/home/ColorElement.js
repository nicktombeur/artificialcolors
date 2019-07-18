import React, {Component} from 'react';

class ColorElement extends Component {

    render() {
        const colors = this.props.color;

        return (
            <li className={"color-card-item color-card-item--" + (colors.natural ? 'green' : 'red')}>
                <img src={"icons/" + (colors.natural ? 'ok.png' : 'nok.png')} alt="Natural status"/>
                <h1>{colors.code}</h1>
                <h2>{colors.name}</h2>
            </li>
        );
    }

}

export default ColorElement;
