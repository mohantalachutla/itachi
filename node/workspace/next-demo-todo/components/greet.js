

/**
 * components are different from the pages 
 * Simple react components
 */
const Welcome = ({name}) => {
    return(
        <h2>Welcome {name} </h2>
    )
}

const ThankYou = ({name}) => {
    return(
        <h2>Thank you {name} </h2>
    )
}

exports.Welcome = Welcome
exports.ThankYou = ThankYou