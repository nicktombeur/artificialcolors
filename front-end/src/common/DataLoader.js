class DataLoader {

    load() {
        // TODO use correct URL for environment
        return fetch("http://localhost:8080/number").then((res) => res.json());
    }
}

export default DataLoader;
