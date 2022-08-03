const { Sequelize } = require("sequelize");
const config = {
    user: "root",
    password: "",
    database: "fastcare",
    options: {
        host: "localhost",
        dialect: 'mariadb',
        query: { raw: true },
        port: 3306,
        logging: false,
        dialectOptions: {
            timezone: "Etc/GMT-5",
        },
    },
};
const sequelize = new Sequelize(
    config.database,
    config.user,
    config.password,
    config.options
);

let db = {
    sequelize,
    Sequelize,
    Users: require("./Users")(sequelize, Sequelize),
    Doctor: require('./Doctor')(sequelize, Sequelize),
    Bookings: require('./Bookings')(sequelize, Sequelize),
    CovidReport: require('./CovidReport')(sequelize, Sequelize),
    EyeReport: require('./Eye')(sequelize, Sequelize),
    CardioReport: require('./Cardio')(sequelize, Sequelize),
    KidneyReport: require('./Kidney')(sequelize, Sequelize),
}

db.Users.hasMany(db.Bookings, {
    as: 'bookings',
    foreignKey: 'UserId'
});
db.Bookings.belongsTo(db.Doctor,
    {
        as: 'Bookings',
        foreignKey: 'DoctorId'
    }
);
db.Doctor.hasMany(db.Bookings, {
    as: 'Doctor',
    foreignKey: 'DoctorId'
});
db.Bookings.belongsTo(db.Users, {
    as: 'users',
    foreignKey: 'UserId'
});
// db.Users.hasMany(db.CovidReport);
// db.CovidReport.belongsTo(db.CovidReport);
// db.CovidReport.belongsTo(db.Doctor);


module.exports = db;

// INSERT INTO `doctor`(`name`, `email`, `password`, `special`)
// VALUES(
//     'Dr. A',
//     'covid@gmail.com',
//     'Covid',
//     'Covid'
// )


// INSERT INTO `doctor`(`name`, `email`, `password`, `special`)
// VALUES(
//     'Dr. B',
//     'eye@gmail.com',
//     'Eye',
//     'Eye'
// )

// INSERT INTO `doctor`(`name`, `email`, `password`, `special`)
// VALUES(
//     'Dr. C',
//     'kidney@gmail.com',
//     'Kidney',
//     'Kidney'
// )

// INSERT INTO `doctor`(`name`, `email`, `password`, `special`)
// VALUES(
//     'Dr. D',
//     'cardio@gmail.com',
//     'Cardio',
//     'Cardiology'
// )