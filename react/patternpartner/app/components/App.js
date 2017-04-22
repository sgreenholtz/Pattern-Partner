var React = require('react');
var ReactDOM = require('react-dom');
var Nav = require('./nav');
var App = React.createClass({
  render: function() {
    return <Nav />;
  }
});

module.exports = App;
