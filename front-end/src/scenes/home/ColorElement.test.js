import React from "react";
import {render, unmountComponentAtNode} from "react-dom";
import {act} from "react-dom/test-utils";
import ColorElement from "./ColorElement";

let container = null;
beforeEach(() => {
    container = document.createElement("div");
    document.body.appendChild(container);
});

afterEach(() => {
    unmountComponentAtNode(container);
    container.remove();
    container = null;
});

it("renders natural or artificial", () => {
    const naturalColor = {
        code: "E100",
        name: "Curcumin",
        artificial: false
    };

    act(() => {
        render(<ColorElement color={naturalColor} key={naturalColor.code}/>, container);
    });
    expect(container.querySelector(".color-card-item--green")).toBeDefined();
    expect(container.querySelector("img").getAttribute("src")).toBe("icons/ok.png");
    expect(container.querySelector("h1").textContent).toBe(naturalColor.code);
    expect(container.querySelector("h2").textContent).toBe(naturalColor.name);

    const artificialColor = {
        code: "E102",
        name: "Tartrazine",
        artificial: true
    };

    act(() => {
        render(<ColorElement color={artificialColor} key={artificialColor.code}/>, container);
    });
    expect(container.querySelector(".color-card-item--red")).toBeDefined();
    expect(container.querySelector("img").getAttribute("src")).toBe("icons/nok.png");
    expect(container.querySelector("h1").textContent).toBe(artificialColor.code);
    expect(container.querySelector("h2").textContent).toBe(artificialColor.name);
});
