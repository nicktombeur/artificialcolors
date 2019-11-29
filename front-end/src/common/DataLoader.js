const api = process.env.REACT_APP_API_HOST;

class DataLoader {

    static load() {
        let url = process.env.NODE_ENV === 'development' ? api + "/number" : "/number";
        return fetch(url).then((res) => res.json());
    }
}

export default DataLoader;
