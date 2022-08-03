module.exports = (sequelize, { DataTypes }) => {
    const CovidReport = sequelize.define(
        "CovidReport",
        {
            uid: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            name: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            age: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            gender: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            regDate: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            collectedDate: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            desc: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            vaccine: {
                type: DataTypes.STRING,
                allowNull: false,
            },
        },
        {
            sequelize,
            tableName: 'covidReport',
            timestamps: false,
            createdAt: false,
            updatedAt: false,
        }
    );
    return CovidReport;
};