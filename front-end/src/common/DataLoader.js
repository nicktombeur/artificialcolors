const api = process.env.REACT_APP_API_HOST;

class DataLoader {

    static load() {
        return fetch(api + "/number").then((res) => res.json());
    }
}

export default DataLoader;
