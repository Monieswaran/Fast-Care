module.exports = (sequelize, { DataTypes }) => {
    const KidneyReport = sequelize.define(
        "kidneyReport",
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
            glucose: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            wbc: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            rbc: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            egfr: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            ureaNitrogen: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            sodium: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            potassium: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            cloride: {
                type: DataTypes.STRING,
                allowNull: false,
            },
        },
        {
            sequelize,
            tableName: 'kidneyReport',
            timestamps: false,
            createdAt: false,
            updatedAt: false,
        }
    );
    return KidneyReport;
};