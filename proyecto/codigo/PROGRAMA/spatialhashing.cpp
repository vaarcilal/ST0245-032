#include <bits/stdc++.h>
#include <boost/algorithm/string.hpp>
#include <boost/unordered_map.hpp>
#include <chrono>
#include <cmath>
#include <fstream>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>

class Bee {
public:
    double x, y, z;
    Bee* previous = nullptr;
    Bee* following = nullptr;

    Bee(double x1, double y1, double z1)
    {
        x = x1 * 111111;
        y = y1 * 111111;
        z = z1;
    };

    Bee(const Bee& b)
    {
        x = b.x * 111111;
        y = b.y * 111111;
    };
};

class Cube {
public:
    int x, y, z;
    Cube(int x, int y, int z)
    {
        this->x = x * 111111;
        this->y = y * 111111;
        this->z = z;
    }
};

std::string find_cube_key(double x, double y, double z)
{
    // round each coordinate, concatenate them into a string and convert this string to an integer
    return std::to_string((int)std::round(x / 57.735026919)) + " " + std::to_string((int)std::round(y / 57.735026919)) + " " + std::to_string((int)std::round(z / 57.735026919));
}

void parse_file(std::string input_file, std::vector<std::string>& v, boost::unordered_map<std::string, std::pair<Bee*, bool>>& um)
{
    std::ifstream inpp(input_file);
    std::string line;
    std::getline(inpp, line);
    if (inpp.is_open()) {
        while (std::getline(inpp, line)) {
            std::vector<std::string> string_coordinates;
            boost::split(string_coordinates, line, boost::is_any_of(","));
            Bee* c = new Bee(std::stod(string_coordinates[0]), std::stod(string_coordinates[1]), std::stod(string_coordinates[2]));
            std::string key = find_cube_key(c->x, c->y, c->z);
            if ((um[key].first) == nullptr) {
                um[key] = std::make_pair(c, false);
                v.push_back(key);
            } else {
                um[key].second = true;
                um[key].first->previous = c;
                c->following = um[key].first;
                um[key].first = c;
            }
        }
    }
    inpp.close();
}

inline void find_for_unique_bee(std::string unique_bee_key, boost::unordered_map<std::string, std::pair<Bee*, bool>>& cubes)
{
    double x = cubes[unique_bee_key].first->x, y = cubes[unique_bee_key].first->y, z = cubes[unique_bee_key].first->z;
    std::stringstream result;
    std::vector<std::string> xyz_from_key;
    boost::split(xyz_from_key, unique_bee_key, boost::is_any_of(" "));
    int x_idx = stoi(xyz_from_key[0]), y_idx = stoi(xyz_from_key[1]), z_idx = stoi(xyz_from_key[2]);

    std::vector<std::string> keys;
    keys.reserve(26);

    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx));
    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx - 1));

    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx) + " " + std::to_string(z_idx));
    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx) + " " + std::to_string(z_idx - 1));

    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx));
    xyz_from_key.push_back(std::to_string(x_idx + 1) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx - 1));

    xyz_from_key.push_back(std::to_string(x_idx) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx));
    xyz_from_key.push_back(std::to_string(x_idx) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx - 1));

    xyz_from_key.push_back(std::to_string(x_idx) + " " + std::to_string(y_idx) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx) + " " + std::to_string(y_idx) + " " + std::to_string(z_idx - 1));

    xyz_from_key.push_back(std::to_string(x_idx) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx));
    xyz_from_key.push_back(std::to_string(x_idx) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx - 1));

    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx));
    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx + 1) + " " + std::to_string(z_idx - 1));

    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx) + " " + std::to_string(z_idx));
    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx) + " " + std::to_string(z_idx - 1));

    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx + 1));
    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx));
    xyz_from_key.push_back(std::to_string(x_idx - 1) + " " + std::to_string(y_idx - 1) + " " + std::to_string(z_idx - 1));

    Bee* current_bee;
    for (std::string key : keys) {
        if (cubes[key].first != nullptr) {
            current_bee = cubes[key].first;
            double x_distance, y_distance, z_distance;
            //  int cont =0;
            do {
                x_distance = x - current_bee->x;
                y_distance = y - current_bee->y;
                z_distance = z - current_bee->z;
                //    ++cont;
                //    std::cout<<cont<<"\n";
                if (x_distance >= -100 && x_distance <= 100) {
                    if (y_distance >= -100 && y_distance <= 100) {
                        if (z_distance >= -100 && z_distance <= 100) {
                            if (cubes[key].second == true) {
                                //result << x << "," << y << "," << z << "\n";
                                cubes[unique_bee_key].second = true;
                                return; //result.str();
                            } else {
                                // result << current_bee->x << "," << current_bee->y << "," << current_bee->z << "\n";
                                //result << x << "," << y << "," << z << "\n";
                                cubes[key].second = true;
                                cubes[unique_bee_key].second = true;
                                return; //result.str();
                            }
                        }
                    }
                }
            } while (current_bee->following != nullptr);
        }
    }
    //return result.str();
}

Bee* tony;
double x, y, z;

int main()
{
    // map trepresent cubes
    boost::unordered_map<std::string, std::pair<Bee*, bool>> cubes;

    // vector to store keys and int representing how many bees are in each cube
    std::vector<std::string> keys;

    // string storing name of file that will be parsed
    std::string inFileName = "ConjuntoDeDatosCon1000000abejas.txt";
    std::stringstream s;

    auto duration_mean = std::chrono::system_clock::duration::zero().count();
    auto duration_max = std::chrono::system_clock::duration::min().count();
    auto duration_min = std::chrono::system_clock::duration::max().count();
    for (int i = 0; i < 10; ++i) {
        auto st = std::chrono::high_resolution_clock::now();
        parse_file(inFileName, keys, cubes);

        auto stop1 = std::chrono::high_resolution_clock::now();
        auto dif = std::chrono::duration_cast<std::chrono::microseconds>(stop1 - st).count();
        if (dif > duration_max) {
            duration_max = dif;
        } else if (dif < duration_min) {
            duration_min = dif;
        }
        duration_mean += dif;
    }
    //    clock_t start, end;
    std::cout << "PARSE_FILE mean: " << duration_mean / 10 << std::endl;
    std::cout << "PARSE_FILE max: " << duration_max << std::endl;
    std::cout << "PARSE_FILE min: " << duration_min << std::endl;


    duration_mean = std::chrono::system_clock::duration::zero().count();
    duration_max = std::chrono::system_clock::duration::min().count();
    duration_min = std::chrono::system_clock::duration::max().count();
    for (int i = 0; i < 10; ++i) {
        auto st = std::chrono::high_resolution_clock::now();
        for (std::string key : keys) {
            std::pair<Bee*, bool> p = cubes[key];
            tony = p.first;
            if (p.second == true) {
                while (tony->following != nullptr) {
                    // s << tony->x << "," << tony->y << "," << tony->z << "\n";
                    tony = tony->following;
                }
            } else {
                find_for_unique_bee(key, cubes);
            }
        }
        auto stop1 = std::chrono::high_resolution_clock::now();
        auto dif = std::chrono::duration_cast<std::chrono::microseconds>(stop1 - st).count();
        if (dif > duration_max) {
            duration_max = dif;
        } else if (dif < duration_min) {
            duration_min = dif;
        }
        duration_mean += dif;
    }
    std::cout << "FIND_COLLISIONS mean: " << duration_mean / 10 << std::endl;
    std::cout << "FIND_COLLISIONS max: " << duration_max<< std::endl;
    std::cout << "FIND_COLLISIONS min: " << duration_min<< std::endl;
    //   end = std::clock();

    //std::cout <<"CHRONO: " << duration.count() << "\n";
    //std::cout << s.str();
    //double time_taken = double(end - start) / double(CLOCKS_PER_SEC);
    //std::cout << s.str() << "\n";
}
