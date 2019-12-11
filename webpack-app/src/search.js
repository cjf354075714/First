import React from 'react';
import ReactDOM from 'react';
import './search.css';

class Search extends React.Component {
    render() {
        return <div className={"search-text"}>Search Test</div>;
    }
}

ReactDOM.render(
    <Search />,
    document.getElementById('root')
);