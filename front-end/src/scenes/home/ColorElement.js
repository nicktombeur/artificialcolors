import React, {Component} from "react";

class ColorElement extends Component {

    render() {
        const colors = this.props.color;

        return (
            <li className={"color-card-item color-card-item--" + (colors.artificial ? "red" : "green")}>
                <img src={"icons/" + (colors.artificial ? "nok.png" : "ok.png")} alt="Natural status"/>
                <h1>{colors.code}</h1>
                <h2>{colors.name}</h2>
            </li>
        );
    }

}

export default ColorElement;
